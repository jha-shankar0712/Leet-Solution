var subsets = function(nums) {
    let result = [];

    function backtrack(start, current) {
        // Har current combination ek valid subset hai
        result.push([...current]);

        for (let i = start; i < nums.length; i++) {
            current.push(nums[i]);

            backtrack(i + 1, current);

            current.pop();
        }
    }

    backtrack(0, []);

    return result;
};