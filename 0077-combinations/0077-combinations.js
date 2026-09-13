var combine = function(n, k) {
    let result = [];

    function backtrack(start, current) {
        // k numbers complete ho gaye
        if (current.length === k) {
            result.push([...current]);
            return;
        }

        // Numbers choose karo
        for (let i = start; i <= n; i++) {
            current.push(i);

            backtrack(i + 1, current);

            current.pop();
        }
    }

    backtrack(1, []);

    return result;
};