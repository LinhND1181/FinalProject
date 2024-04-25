export interface Category {
    id: number;
    name: string;
    parentCategoryId: string;

}

export class CategoryModel implements Category {

    id: number;
    name: string;
    parentCategoryId: string;

    constructor(
        id: number,
        name: string,
        parentCategoryId: string,
    ){
        this.id = id;
        this.name = name;
        this.parentCategoryId = parentCategoryId;
    }


}
