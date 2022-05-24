import {Ingredient} from "./Ingredient";

export interface Recipe {
  id?: number;
  name?: string;
  time?: number;
  image? : string;
  actionsSequence? : string;
  originalId? : string;
  ingredients?: string[];
  cuisine?: string;
  meal?: string;
  dish?:string;
}
