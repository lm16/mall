package com.store.controller.authController;

import com.store.model.result.Result;
import com.store.model.result.ResultType;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("authLogout")
public class AuthLogoutController {

    @ApiOperation(value="做登出")
    @GetMapping()
    public Result authLogout(HttpSession session){
        session.invalidate();

        return Result.build(ResultType.Success);
    }

}
