package foodtogo.application.rest;

import foodtogo.cqrs.CommandBus;
import foodtogo.domain.NewEntityResult;
import foodtogo.domain.restaurant.CreateRestaurantCommand;
import foodtogo.domain.restaurant.Restaurant;
import foodtogo.domain.restaurant.RestaurantRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final CommandBus commandBus;
    private final RestaurantRepository restaurantRepository;

    @PostMapping("/restaurant")
    public NewEntityResult createRestaurant(@RequestBody @Valid CreateRestaurantCommand command) {
        return commandBus.dispatch(command).getResult();
    }

    @GetMapping("/restaurant/{restaurantId}")
    public Restaurant getRestaurant(@PathVariable("restaurantId") Long id) {
        return restaurantRepository.findById(id).orElseThrow();
    }
}
