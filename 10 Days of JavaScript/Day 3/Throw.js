// Link to the problem: https://www.hackerrank.com/challenges/js10-throw/problem

/*
 * Complete the isPositive function.
 * If 'a' is positive, return "YES".
 * If 'a' is 0, throw an Error with the message "Zero Error"
 * If 'a' is negative, throw an Error with the message "Negative Error"
 */

function UserException(message) {
    this.message = message;
}

function isPositive(a) {
    if (a > 0) {
        return "YES";
    } else if (a === 0) {
        throw new UserException("Zero Error");
    } else {
        throw new UserException("Negative Error");
    }
}

