package io.egen.apollo.controller;

import java.util.List;

import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.Genre;
import io.egen.apollo.exceptions.MovieAlreadyExistsException;
import io.egen.apollo.exceptions.MovieNotFoundException;
import io.egen.apollo.service.MovieService;
import io.egen.apollo.service.GenreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/genre")
@Api(tags="genre")
public class GenreController {
	
	@Autowired
	private GenreService service;
	
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Find All Movie Genre",
	notes="Returns a list of the movie genre in the system.")	
	@ApiResponses(value={
		@ApiResponse(code=200, message="Success"),
		@ApiResponse(code=500, message="Internal Server Error")
	})
	public List<Genre> findAll()
	{		
		return service.findAllMovieGenre();		
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Find Movie Genre By Id",
	notes="Returns a movie genre by it's if it exists.")
	@ApiResponses(value={
		@ApiResponse(code=200, message="Success"),
		@ApiResponse(code=404, message="Not Found"),
		@ApiResponse(code=500, message="Internal Server Error")
	})
	public Genre findOne(@PathVariable("id") String id) {
		return service.findMovieGenreById(id);
	}

	@RequestMapping(method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Create Movie Type",
	notes="Create and return movie genre")
	@ApiResponses(value={
		@ApiResponse(code=200, message="Success"),
		@ApiResponse(code=400, message="Bad Request"),
		@ApiResponse(code=500, message="Internal Server Error")
	})	
	public Genre create(@RequestBody Genre genre){
		return service.createMovieGenre(genre);
	}
	
	@RequestMapping(value="{id}", 
			method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Update Movie Genre",
	notes="Update an existing movie genre")
	@ApiResponses(value={
		@ApiResponse(code=200, message="Success"),
		@ApiResponse(code=400, message="Bad Request"),
		@ApiResponse(code=404, message="Not Found"),
		@ApiResponse(code=500, message="Internal Server Error")
	})
	public Genre update (@PathVariable("id") String id, @RequestBody Genre Genre) throws MovieNotFoundException {
		return service.updateMovieGenre(id, Genre);
	}
	
	@RequestMapping(value="{id}", 
			method=RequestMethod.DELETE,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Deleted Movie Genre",
	notes="Update an existing movie genre")
	public void delete(@PathVariable("id") String id) {		
		Genre mv = findOne(id);
		service.deleteMovieGenre(mv);
	}	

}
