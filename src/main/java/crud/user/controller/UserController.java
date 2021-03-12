package crud.user.controller;

import crud.base.BaseController;
import crud.user.api.UserApi;
import crud.user.model.User;
import crud.user.service.UserService;

public class UserController extends BaseController<User, UserService> implements UserApi {
}
