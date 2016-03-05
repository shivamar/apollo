package io.egen.apollo.controller;

import java.util.List;

import io.egen.apollo.entity.Movie;
import io.egen.apollo.entity.Crew;
import io.egen.apollo.exceptions.MovieAlreadyExistsException;
import io.egen.apollo.exceptions.MovieNotFoundException;
import io.egen.apollo.service.CrewService;
import io.egen.apollo.service.MovieService;
import io.egen.apollo.service.CrewService;
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
@RequestMapping("/crew")
@Api(tags="crew")
public class CrewController {
	
	@Autowired
	private CrewService service;
	
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Find All Movie Crew",
	notes="Returns a list of the movie crew in the system.")	
	@ApiResponses(value={
		@ApiResponse(code=200, message="Success"),
		@ApiResponse(code=500, message="Internal Server Error")
	})
	public List<Crew> findAll()
	{		
		return service.findAllMovieCrew();		
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Find Movie Crew By Id",
	notes="Returns a movie crew by it's if it exists.")
	@ApiResponses(value={
		@ApiResponse(code=200, message="Success"),
		@ApiResponse(code=404, message="Not Found"),
		@ApiResponse(code=500, message="Internal Server Error")
	})
	public Crew findOne(@PathVariable("id") String id) {
		return service.findMovieCrewById(id);
	}

	@RequestMapping(method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Create Movie Crew",
	notes="Create and return movie crew")
	@ApiResponses(value={
		@ApiResponse(code=200, message="Success"),
		@ApiResponse(code=400, message="Bad Request"),
		@ApiResponse(code=500, message="Internal Server Error")
	})	
	public Crew create(@RequestBody Crew crew){
		return service.createMovieCrew(crew);
	}
	
	@RequestMapping(value="{id}", 
			method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Update Movie Crew",
	notes="Update an existing movie crew")
	@ApiResponses(value={
		@ApiResponse(code=200, message="Success"),
		@ApiResponse(code=400, message="Bad Request"),
		@ApiResponse(code=404, message="Not Found"),
		@ApiResponse(code=500, message="Internal Server Error")
	})
	public Crew update (@PathVariable("id") String id, @RequestBody Crew crew) throws MovieNotFoundException {
		return service.updateMovieCrew(id, crew);
	}
	
	@RequestMapping(value="{id}", 
			method=RequestMethod.DELETE,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Deleted Movie Crew",
	notes="Update an existing movie crew")
	public void delete(@PathVariable("id") String id) {		
		Crew mv = findOne(id);
		service.deleteMovieCrew(mv);
	}	

}
