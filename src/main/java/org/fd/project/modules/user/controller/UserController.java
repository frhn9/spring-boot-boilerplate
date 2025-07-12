package org.fd.project.modules.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.fd.project.modules.user.dto.request.UserRequest;
import org.fd.project.modules.user.model.entity.User;
import org.fd.project.modules.user.service.core.UserService;
import org.fd.project.shared.constant.enums.ResponseEnum;
import org.fd.project.shared.dto.template.ResponseData;
import org.fd.project.shared.utils.ResponseHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final ResponseHelper responseHelper;

    @PostMapping
    public ResponseEntity<ResponseData<User>> createNewUser(@Valid @RequestBody UserRequest request) {
        return responseHelper.createResponseData(
                ResponseEnum.SUCCESS,
                userService.save(request)
        );
    }

}
