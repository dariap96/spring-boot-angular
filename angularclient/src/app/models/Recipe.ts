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
// export interface Recipe {
//     data :  Datum;
//     links : DatumLinks;
// }
//
// export interface Datum {
//     id :            number;
//     type :          Type;
//     links :         DatumLinks;
//     attributes :    Attributes;
//    // relationships : Relationships;
//}
//
// export interface Attributes {
//     name : string;
//     time : number;
//     image : string;
//     actionsSequence : string;
//     originalId : string;
// }

// export interface DatumLinks {
//     self : string;
// }

// export interface Relationships {
//     meals : Meals;
//     dishes : Dishes;
//     cuisines : Cuisines;
// }
//
// export enum Type {
//     Recipe = "recipe",
// }
