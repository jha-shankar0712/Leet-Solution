var minWindow = function(s, t) {
    if (t.length > s.length) return "";

    let need = new Map();

    // Count characters required from t
    for (let ch of t) {
        need.set(ch, (need.get(ch) || 0) + 1);
    }

    let left = 0;
    let right = 0;

    let required = t.length;
    let start = 0;
    let minLength = Infinity;

    while (right < s.length) {
        let ch = s[right];

        // If character is needed
        if (need.has(ch)) {
            if (need.get(ch) > 0) {
                required--;
            }

            need.set(ch, need.get(ch) - 1);
        }

        right++;

        // Window is valid
        while (required === 0) {
            // Update minimum window
            if (right - left < minLength) {
                minLength = right - left;
                start = left;
            }

            let leftChar = s[left];

            if (need.has(leftChar)) {
                need.set(leftChar, need.get(leftChar) + 1);

                // Requirement is no longer satisfied
                if (need.get(leftChar) > 0) {
                    required++;
                }
            }

            left++;
        }
    }

    if (minLength === Infinity) {
        return "";
    }

    return s.substring(start, start + minLength);
};