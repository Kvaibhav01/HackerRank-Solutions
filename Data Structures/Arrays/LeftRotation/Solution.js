'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));
    main();
});

function readLine() {
    return inputString[currentLine++];
}

function rotateAndPrint(arr, d) {
    let rotatedArray = [];

    // First, we need to allocate the required space.
    for (let i = 0; i < arr.length; i += 1) {
        rotatedArray.push(0);
    }

    // Then, we perform the actual rotation. We use the modulo in order to calculate the rotated position. The array length is added to avoid negative numbers.
    for (let i = 0; i < arr.length; i += 1) {
        let rotatedPosition = (i - d + arr.length) % arr.length;
        rotatedArray[rotatedPosition] = arr[i];
    }

    // Finally, write the rotated array 
    process.stdout.write(rotatedArray.join(" "));
}

function main() {
    const nd = readLine().split(' ');
    const n = parseInt(nd[0], 10);
    const d = parseInt(nd[1], 10);
    const a = readLine().split(' ').map(aTemp => parseInt(aTemp, 10));
    rotateAndPrint(a, d);
}
