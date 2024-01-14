/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    const cache = {};
    let callCount = 0;

    return function(...args) {
        const key = JSON.stringify(args);

        if (cache.hasOwnProperty(key)) {
            // If the result is already cached, return it
            return cache[key];
        } else {
            // Otherwise, call the original function, cache the result, and return it
            callCount += 1;
            const result = fn(...args);
            cache[key] = result;
            return result;
        }
    };
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */