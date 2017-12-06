package com.qaprosoft.argon.ws.controller;

//import java.util.ArrayList;
//import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//import com.qaprosoft.argon.models.db.Group;
import com.qaprosoft.argon.models.db.User;
import com.qaprosoft.argon.models.dto.UserType;
import com.qaprosoft.argon.models.dto.auth.AccessTokenType;
import com.qaprosoft.argon.models.dto.auth.AuthTokenType;
import com.qaprosoft.argon.models.dto.auth.CredentialsType;
import com.qaprosoft.argon.models.dto.auth.RefreshTokenType;
import com.qaprosoft.argon.services.exceptions.ForbiddenOperationException;
import com.qaprosoft.argon.services.exceptions.InvalidCredentialsException;
import com.qaprosoft.argon.services.exceptions.ServiceException;
import com.qaprosoft.argon.services.exceptions.UserNotFoundException;
import com.qaprosoft.argon.services.services.UserService;
import com.qaprosoft.argon.services.services.auth.JWTService;
import com.qaprosoft.argon.ws.swagger.annotations.ResponseStatusDetails;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "Auth API")
@CrossOrigin
@RequestMapping("api/auth")
public class AuthAPIController extends AbstractController
{
	@Autowired
	private JWTService jwtService;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private Mapper mapper;

	@Value("${argon.admin.username}")
	private String adminUsername;

	@ResponseStatusDetails
	@ApiOperation(value = "Generates auth token", nickname = "login", code = 200, httpMethod = "POST", response = AuthTokenType.class)
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AuthTokenType login(@Valid @RequestBody CredentialsType credentials)
			throws BadCredentialsException
	{
		AuthTokenType authToken = null;
//		try
//		{
//			Authentication authentication = this.authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
//
//			SecurityContextHolder.getContext().setAuthentication(authentication);
//
//			User user = userService.getUserByUsername(credentials.getUsername());
//
//			authToken = new AuthTokenType("Bearer", jwtService.generateAuthToken(user),
//					jwtService.generateRefreshToken(user), jwtService.getExpiration());
//		} catch (Exception e)
//		{
//			throw new BadCredentialsException(e.getMessage());
//		}
		return authToken;
	}

	@ResponseStatusDetails
	@ApiOperation(value = "Registration", nickname = "register", code = 200, httpMethod = "POST")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void register(@Valid @RequestBody UserType userType) throws BadCredentialsException, ServiceException
	{
		// List<Group.Role> roles = new ArrayList<>();
		// roles.add(Group.Role.ROLE_USER);
		// userType.setRoles(roles);
//		userService.createUser(mapper.map(userType, User.class));
	}

	@ResponseStatusDetails
	@ApiOperation(value = "Refreshes auth token", nickname = "refreshToken", code = 200, httpMethod = "POST", response = AuthTokenType.class)
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "refresh", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AuthTokenType refresh(@RequestBody @Valid RefreshTokenType refreshToken)
			throws BadCredentialsException, ForbiddenOperationException
	{
		AuthTokenType authToken = null;
//		try
//		{
//			User jwtUser = jwtService.parseRefreshToken(refreshToken.getRefreshToken());
//
//			User user = userService.getUserById(jwtUser.getId());
//			if (user == null)
//			{
//				throw new UserNotFoundException();
//			}
//
//			// TODO: Do not verify password for demo user as far as it breaks demo JWT token
//			if (!StringUtils.equals(adminUsername, user.getUsername())
//					&& !StringUtils.equals(user.getPassword(), jwtUser.getPassword()))
//			{
//				throw new InvalidCredentialsException();
//			}
//
//			authToken = new AuthTokenType("Bearer", jwtService.generateAuthToken(user),
//					jwtService.generateRefreshToken(user), jwtService.getExpiration());
//		} catch (Exception e)
//		{
//			throw new ForbiddenOperationException(e);
//		}

		return authToken;
	}

//	@ResponseStatusDetails
//	@ApiOperation(value = "Generates access token", nickname = "accessToken", code = 200, httpMethod = "GET", response = AuthTokenType.class)
//	@ResponseStatus(HttpStatus.OK)
//	@ApiImplicitParams(
//	{ @ApiImplicitParam(name = "Authorization", paramType = "header") })
//	@RequestMapping(value = "access", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody AccessTokenType accessToken() throws ServiceException
//	{
//		String token = jwtService.generateAccessToken(userService.getNotNullUserById(getPrincipalId()));
//		return new AccessTokenType(token);
//	}
}
