package io.egen.apollo.controller;

import java.util.ArrayList;
import java.util.List;

import io.egen.apollo.entity.Movie;
import io.egen.apollo.exceptions.MovieNotFoundException;
import io.egen.apollo.service.MovieService;
import io.egen.apollo.entity.User;
import io.egen.apollo.exceptions.UserNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@Api(tags="movies")
public class MovieController{	
	
	@Autowired
	private MovieService service;
	
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Find All Movies",
	notes="Returns a list of the movies in the system.")	
	@ApiResponses(value={
		@ApiResponse(code=200, message="Success"),
		@ApiResponse(code=500, message="Internal Server Error")
	})
	public List<Movie> findAll()
	{		
		return service.findAllMovies();		
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Find Movie By Id",
	notes="Returns a movie by it's if it exists.")
	@ApiResponses(value={
		@ApiResponse(code=200, message="Success"),
		@ApiResponse(code=404, message="Not Found"),
		@ApiResponse(code=500, message="Internal Server Error")
	})
	public Movie findOne(@PathVariable("id") String id) throws MovieNotFoundException {
		return service.findMovieById(id);
	}
	
	
}
