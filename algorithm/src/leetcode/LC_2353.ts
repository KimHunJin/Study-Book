class FoodRatings {

    cuisineMap = new Map() // key: cuisine, value: food[]
    highestRatingCuisineMap = new Map() // key: cuisine, value: { food, rating }
    foodMap = new Map() // key: food, value: { cuisine, rating }

    constructor(foods: string[], cuisines: string[], ratings: number[]) {
        foods.forEach((food, idx) => {
            const cuisine = cuisines[idx]
            const rating = ratings[idx]
            this.foodMap.set(food, { cuisine, rating })
            if (this.cuisineMap.has(cuisine)) {
                const arr = this.cuisineMap.get(cuisine)
                arr.push(food)
                this.cuisineMap.set(cuisine, arr)
            } else {
                this.cuisineMap.set(cuisine, [food])
            }

            if (this.highestRatingCuisineMap.has(cuisine)) {
                const highestRating = this.highestRatingCuisineMap.get(cuisine)
                if (rating > highestRating.rating) {
                    this.highestRatingCuisineMap.set(cuisine, { food, rating })
                } else if(rating === highestRating.rating) {
                    // dictional priority
                    if (this.isFastPriority(food, highestRating.food)) {
                        this.highestRatingCuisineMap.set(cuisine, { food, rating })
                    }
                }
            } else {
                this.highestRatingCuisineMap.set(cuisine, { food, rating })
            }
        })
    }

    isFastPriority(foodA: string, foodB: string) {
        return foodA < foodB
    }

    changeRating(food: string, newRating: number): void {
        const foodInfo = this.foodMap.get(food)
        const cuisine = foodInfo.cuisine
        this.foodMap.set(food, { cuisine, rating: newRating})
        const highestRating = this.highestRatingCuisineMap.get(cuisine)

        if (highestRating.food === food) {
            const foodArr = this.cuisineMap.get(cuisine)
            let rating = 0
            let highestFood

            foodArr.forEach(food => {
                const foodInfo = this.foodMap.get(food)
                if (foodInfo.rating > rating) {
                    rating = foodInfo.rating
                    highestFood = food
                } else if (foodInfo.rating === rating) {
                    if (this.isFastPriority(food, highestFood)) {
                        highestFood = food
                    }
                }
            })
            this.highestRatingCuisineMap.set(cuisine, { food: highestFood, rating })
        } else {
            if (highestRating.rating < newRating) {
                this.highestRatingCuisineMap.set(cuisine, { food, rating: newRating })
            } else if (highestRating.rating === newRating) {
                if (this.isFastPriority(food, highestRating.food)) {
                    this.highestRatingCuisineMap.set(cuisine, { food, rating: newRating })
                }
            }
        }
    }

    highestRated(cuisine: string): string {
        return this.highestRatingCuisineMap.get(cuisine).food
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * var obj = new FoodRatings(foods, cuisines, ratings)
 * obj.changeRating(food,newRating)
 * var param_2 = obj.highestRated(cuisine)
 */

