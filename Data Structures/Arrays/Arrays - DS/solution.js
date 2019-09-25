// Helper function: just swap two places in the array
function swap(array, a, b) {
    let tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
}
// In-place reverse.
function reverseArray(a) {
    for (let i = 0; i < a.length / 2; i += 1) {
        swap(a, i, a.length - 1 - i);
    }
    return a;
}