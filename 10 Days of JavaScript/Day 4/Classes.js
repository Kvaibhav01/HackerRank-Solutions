// Link to the problem: https://www.hackerrank.com/challenges/js10-class/problem

/*
 * Implement a Polygon class with the following properties:
 * 1. A constructor that takes an array of integer side lengths.
 * 2. A 'perimeter' method that returns the sum of the Polygon's side lengths.
 */

class Polygon {
    constructor(lengths) {
        var poly_peri = 0;

        for (var i in lengths) {
                poly_peri += lengths[i];
        }
        
        this.my_perimeter = poly_peri;
    }
    
     perimeter() {
        return this.my_perimeter;
    }
    
}
