function checkPossibility(nums: number[]): boolean {

    let count = 0;


    if (nums.length < 3) {
        return true;
    }


    let first = nums[0];
    let second = nums[1];

    if (first > second) {
        first = second;
        count++;
    }

    for (let i=2; i<nums.length; i++) {
        let current = nums[i];
        if (current >= second) {
            first = second;
            second = current;
        } else {
            if ( count > 0) {
                return false;
            } else {
                if (current >= first) {
                    first = current;
                    second = current;
                } else {
                    first = second;
                }
                count++;
            }
        }
    }

    return count < 2;
};
