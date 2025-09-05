package foodtogo.application.rest;

import foodtogo.cqrs.CommandBus;
import foodtogo.domain.NewEntityResult;
import foodtogo.domain.account.Account;
import foodtogo.domain.restaurant.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MenuController {

    private final CommandBus commandBus;
    private final MenuRepository menuRepository;
    private final MenuItemRepository menuItemRepository;
    private final MenuCategoryRepository menuCategoryRepository;

    @PostMapping("/menu")
    public NewEntityResult createMenu(@RequestBody @Valid CreateMenuCommand command) {
        return commandBus.dispatch(command).getResult();
    }

    @GetMapping("/menu/{menuId}")
    public ResponseEntity<Menu> getMenu(@PathVariable("menuId") Long id) {
        var menu = menuRepository.findById(id);
        return menu.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/menu-item")
    public NewEntityResult createMenuItem(@RequestBody @Valid CreateMenuItemCommand command) {
        return commandBus.dispatch(command).getResult();
    }

    @GetMapping("/menu-item/{menuItemId}")
    public ResponseEntity<Menu> getMenuItem(@PathVariable("menuItemId") Long id) {
        var menuItem = menuRepository.findById(id);
        return menuItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/menu-category")
    public NewEntityResult createMenuCategory(@RequestBody @Valid CreateMenuCategoryCommand command) {
        return commandBus.dispatch(command).getResult();
    }

    @GetMapping("/menu-category/{menuCategoryId}")
    public ResponseEntity<Menu> getMenuCategory(@PathVariable("menuCategoryId") Long id) {
        var menuCategory = menuRepository.findById(id);
        return menuCategory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
