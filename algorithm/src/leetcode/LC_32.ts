function longestValidParentheses(s: string): number {
    let open = 0;
    let index = 0;

    let result = 0;

    const stack = [];

    for (let i=0; i<s.length; i++) {
        const c = s[i];
        if (c === '(') {
            open++;
            index++;
            stack.push(c);
        } else {
            if (open > 0) {
                let isAble = true;
                let popNumber = 0;
                while(isAble) {

                    const popC = stack[index - 1];
                    index = index-1;
                    stack.splice(index, 1);

                    if (index - 1 < 0) {
                        // console.log('is able change index');
                        isAble = false;
                    }

                    if (typeof popC === 'number') {
                        popNumber += popC;
                    }

                    if (popC === '(') {
                        popNumber += 1;

                        while(typeof stack[index - 1] === 'number') {
                            popNumber += stack[index - 1];
                            stack.splice(index-1, 1);
                            index--;
                        }


                        index++;
                        result = Math.max(result, popNumber);
                        open--;
                        stack.push(popNumber);
                        isAble = false;
                        // console.log('is able change open');
                    }

                    if (popC === ')') {
                        // console.log('is able change close');
                        isAble = false;
                    }


                }
            } else {
                index++;
                stack.push(c);
            }
        }
        // console.log('count', i, 'stack', stack);
    }

    return result * 2;
};
