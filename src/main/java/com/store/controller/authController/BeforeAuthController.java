package com.store.controller.authController;

import com.store.model.basic.Auth;
import com.store.model.result.Result;
import com.store.model.result.ResultType;
import com.store.service.basic.AuthIdService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("beforeAuth")
public class BeforeAuthController {

    @Autowired
    private AuthIdService authIdService;

    @PutMapping()
    @ApiOperation(value="做登入操作")
    public Result befoerAuthPut(@RequestBody Auth auth, HttpSession session){

        int id = authIdService.login(auth);
        if(id > 0){

            if(session.getAttribute("auth") == null){

                session.setAttribute("auth", String.valueOf(id));

                return Result.build(ResultType.Success);
            }

            return Result.build(ResultType.Failed);

        }

        return Result.build(ResultType.Failed);

    }

    @GetMapping()
    @ApiOperation(value="做登入状态")
    public Result beforeAuthGet(HttpSession session){

        if(session.getAttribute("auth") == null){

            return Result.build(ResultType.Unauthenticated);

        } else{

            return Result.build(ResultType.Authenticated);

        }

    }

}
