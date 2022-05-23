import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { RecipeService } from "../_services/recipe.service";
import { Recipe } from "../models/Recipe";
//import { UserInfo } from "../models/User";
//import { Selections } from "../model/Selections";
import { ThemePalette } from "@angular/material/core";
import {TokenStorageService} from "../_services/token-storage.service";
//import { RecipeRatingInfo } from "../model/RecipesRatingsInfo";
//import { Labels } from "../model/Labels";

@Component({
    selector: 'app-recipe-card',
    templateUrl: './recipe-card.component.html',
    styleUrls: ['./recipe-card.component.css']
})

export class RecipeCardComponent implements OnInit {
  //activeUser : UserInfo;
  //userSelections : Selections;
  recipeId: number;
  selectedRecipe!: Recipe;
  //selectedSelection = null;
  relatedIngredients!: string[];
  //rating : string;
  //reviews : RecipeRatingInfo[];
  recipeName: string;
  recipeCookTime: number = -1;
  recipeImg: string;
  recipeDescr: string;
  //recipeLables : Labels;
  background: ThemePalette = undefined;
  input;
  dynamicdata: string = 'This is dynamic data!';
  title = 'socketrv';
  content = '';
  received = [];
  sent = [];
  cuisine: string;
  meal: string;
  dish: string;
  isLoggedIn = false;
  constructor(private route: ActivatedRoute, private service: RecipeService,private tokenStorageService: TokenStorageService,)  {
    this.recipeId = route.snapshot.params['id'];
  }

  ngOnInit() {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    this.service.getRecipeById(this.recipeId).subscribe(data => {
      this.selectedRecipe = data;
      this.recipeName = this.selectedRecipe.name;
      this.recipeCookTime = this.selectedRecipe.time;
      this.recipeImg = this.selectedRecipe.image;
      this.recipeDescr = this.selectedRecipe.actionsSequence;
      this.relatedIngredients = this.selectedRecipe.ingredients;
      this.cuisine = this.selectedRecipe.cuisine;
      this.meal = this.selectedRecipe.meal;
      this.dish = this.selectedRecipe.dish;
    });


    // this.service.getIngredientsByRecipeId(this.recipeId).subscribe( data => {
    //     this.relatedIngredients = data;
    // });

    //     this.service.getRecipeRatingsById(this.recipeId).subscribe(data => {
    //             this.rating = data.toString();
    //     });
    //
    //     this.service.getLabelsByRecipeId(this.recipeId).subscribe(data => {
    //         this.recipeLables = data;
    //     })
    //
    //     this.service.getUserInfo().subscribe( data => {
    //         this.activeUser = data;
    //
    //         this.service.getUserSelections(this.activeUser.login).subscribe( selectionsData => {
    //             this.userSelections = selectionsData;
    //         });
    //     });
    //
    //     this.service.getReviews(this.recipeId).subscribe(data => {
    //         this.reviews = data;
    //     });
    // }
    //
    // selectChangeHandlerSelection(e) {
    //     this.selectedSelection = e.value;
    // }
    //
    // addToSelection() {
    //     if (this.selectedSelection != 'Select selection to save' && this.selectedSelection != null) {
    //         this.service.addRecipeToSelectionById(this.selectedSelection, this.recipeId).subscribe( data => {});
    //     }
    // }
    //
    // PrintRating() {
    //     if (this.rating == '')
    //         return 'Not rated';
    //     else
    //         return 'Rating: ' + this.rating;
    // }
  }
//src\app\app.component.ts
}
