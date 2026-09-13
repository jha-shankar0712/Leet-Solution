var removeDuplicates = function(nums) {
    let k = 0;

    for (let num of nums) {
        // First 2 elements directly allowed
        // Ya current number 2 positions pehle wale se different hai
        if (k < 2 || num !== nums[k - 2]) {
            nums[k] = num;
            k++;
        }
    }

    return k;
};