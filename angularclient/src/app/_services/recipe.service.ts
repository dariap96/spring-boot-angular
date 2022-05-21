import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, map, Observable} from "rxjs";
import {Recipe} from "../models/Recipe";
import {Ingredient} from "../models/Ingredient";
import {Ingredients} from "../models/Ingredients";

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  constructor(private http: HttpClient) {
  }
  RECIPE_URL: string = "http://localhost:8080/api/recipe/"

  public getRecipes(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.RECIPE_URL);
  }
  getPaginatedRecipes(params: any): Observable<any> {
    return this.http.get<any>(this.RECIPE_URL, { params });
  }

  getRecipeById(id: number): Observable<Recipe> {
    return this.http.get<Recipe>(this.RECIPE_URL + id);
  }

  // getIngredientsByRecipeId(id: number) : Observable<Ingredients> {
  //   return this.http.get<Ingredients>(this.RECIPE_URL + '/api/ingredient?filter[ingredientsSet.recipe.id]=' + id);
  // }
  // в ингредиент контроллер


}
