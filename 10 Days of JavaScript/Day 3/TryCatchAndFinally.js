// Link to the problem: https://www.hackerrank.com/challenges/js10-try-catch-and-finally/problem

/*
 * Complete the reverseString function
 * Use console.log() to print to stdout.
 */
 
function reverseString(s) {
    try {
        var split_string = s.split('');
        var reverse = split_string.reverse();
        var join = reverse.join('');
        console.log(join);
    } catch (e) {
        console.log(e.message);
            console.log(s);
    }
}

