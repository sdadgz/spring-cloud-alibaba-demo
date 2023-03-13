package cn.sdadgz.exception;

import cn.sdadgz.common.Result;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.fastjson.JSON;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>
 * 废物本物
 * </p>
 *
 * @author sdadgz
 * @since 2023/2/16 00:52:36
 */
@Component
@Slf4j
public class DefaultBlockExceptionHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        //getRule返回资源、规则的详细信息
        log.info("BlockExceptionHandler BlockException================" + e.getRule());

        Result r = null;
        if (e instanceof FlowException) {
            r = Result.error(100, "接口被限流了");
        } else if (e instanceof DegradeException) {
            r = Result.error(101, "服务降级了");
        } else if (e instanceof ParamFlowException) {
            r = Result.error(102, "热点参数限流了");
        } else if (e instanceof AuthorityException) {
            r = Result.error(104, "授权规则不通过");
        }

        //返回Json数据
        httpServletResponse.setStatus(500);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try (PrintWriter writer = httpServletResponse.getWriter()) {
            writer.write(JSON.toJSONString(r));
            writer.flush();
        } catch (IOException ioException) {
            log.error("异常：{}", ioException.toString());
        }
    }
}
