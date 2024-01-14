var createCounter = function(init) {
    var curr = init;
    return {
        increment: function() {
            return ++curr;
        },
        decrement: function() {
            return --curr;
        },
        reset: function() {
            curr = init;
            return curr;
        }
    };
};