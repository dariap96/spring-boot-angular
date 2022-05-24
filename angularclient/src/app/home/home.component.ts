import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { RecipeService } from "../_services/recipe.service";
import {Recipe} from "../models/Recipe";
import {PageEvent} from "@angular/material/paginator";
import {Observable} from "rxjs";
import {Meal} from "../models/Meal";
import {MealService} from "../_services/meal.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
  content?: string;
  recipes: Recipe[] = [];
  currentRecipe: Recipe={};
  currentIndex = -1;
  name = '';
  page = 2;
  count = 0;
  pageSize = 10;
  pageSizes = [10, 5, 20];
  loading:boolean;
  mealsList : Meal[] = [];
  selectedMeal:Meal;
  mealfiltered: Recipe[];

  constructor(private userService: UserService, private recipeService: RecipeService, private mealService: MealService) { }

  ngOnInit(): void {
    this.loading=true;
    this.retrieveRecipes();
    this.loading = false;
    this.mealService.getMeals().subscribe(data => {
      this.mealsList = data;
    });
  }

  getRequestParams(searchName: string,page: number, pageSize: number): any {
    let params: any = {};
    if (searchName) {
      params[`name`] = searchName;
    }
    if (page) {
      params[`page`] = page - 1;
    }
    if (pageSize) {
      params[`size`] = pageSize;
    }
    return params;
  }

  retrieveRecipes(): void{
    const params = this.getRequestParams(this.name, this.page, this.pageSize);
   this.recipeService.getPaginatedRecipes(params)
      .subscribe(
        response => {
          const { recipes, totalItems } = response;
          this.count = totalItems;
          this.recipes = recipes;
          console.log(response);
        },
        error => {
          console.log(error);
        });
  }

  handlePageChange(event: number): void {
    this.page = event;
    this.retrieveRecipes();
  }

  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retrieveRecipes();
  }

  setActiveRecipe(recipe: Recipe, index: number): void {
    this.currentRecipe = recipe;
    this.currentIndex = index;
    console.log(this.currentIndex);
  }

  refreshList(): void {
    this.retrieveRecipes();
    this.currentRecipe = {};
    this.currentIndex = -1;
  }

  searchName(): void {
    this.page = 1;
    this.retrieveRecipes();
  }

  selectChangeHandlerMeal(e) {
    this.selectedMeal = e.value;
    this.recipes.filter(r=> r.meal===e.value);
    console.log(this.recipes.filter(r=> r.meal===e.value));
  }

  // clearInput() {
  //   this.retrieveRecipes()
  // }

}
