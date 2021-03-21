function validateStackSequences(pushed: number[], popped: number[]): boolean {
    const stack: number[] = [];

    const pushedSize = pushed.length;


    let stackIndex = -1;
    let pushingIndex = 0;

    let popAbled = true;

    for (let i=0; i<popped.length; i++) {
        while(stackIndex === -1 || stack[stackIndex] !== popped[i]) {
            stack.push(pushed[pushingIndex]);
            stackIndex++;
            pushingIndex++;

            if (stackIndex >= pushedSize) {
                popAbled = false;
                break;
            }
        }
        if (!popAbled) {
            break;
        }

        stack.splice(stack.length - 1, 1);
        stackIndex--;
    }

    return popAbled;
};
