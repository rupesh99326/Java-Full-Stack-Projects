import { fooditem } from "src/app/fooditem";

export interface cart
{

    menuItemList:fooditem[];
    // name:string,price:number;
    total:number;
}