package cn.ilanky.web.result.filter;

import cn.ilanky.web.result.ResultContext;
import cn.ilanky.web.result.core.AbstractResult;
import cn.ilanky.web.result.core.ResultRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.filter.OrderedFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ilanky
 * @date 2021年 04月30日 15:04:24
 */
@Component
public class ResultFilter extends OncePerRequestFilter implements OrderedFilter {
    private static final Logger LOG = LoggerFactory.getLogger(ResultFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            AbstractResult abstractResult = ResultContext.get();
            httpServletResponse.setCharacterEncoding("utf-8");
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            if (abstractResult == null){
                return;
            }
            abstractResult.output(httpServletResponse.getWriter());
        }catch (Exception e){
            AbstractResult abstractResult;
            if (e instanceof ResultRuntimeException){
                ResultRuntimeException exception = (ResultRuntimeException) e;
                abstractResult = ResultContext.set(exception.getCarrier(), exception.getResult());
                LOG.error("ResultFilter.doFilterInternal error", exception);
            } else if (e.getCause() instanceof ResultRuntimeException){
                ResultRuntimeException exception = (ResultRuntimeException) e.getCause();
                abstractResult = ResultContext.set(exception.getCarrier(), exception.getResult());
                LOG.error("ResultFilter.doFilterInternal error", exception);
            }else {
                abstractResult = ResultContext.serverError();
                LOG.error("ResultFilter.doFilterInternal error", e);
            }
            abstractResult.output(httpServletResponse.getWriter());
        }finally {
            ResultContext.clear();
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
