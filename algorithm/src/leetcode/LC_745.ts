class Tree {

    value: string = '';
    indexList: number[] = [];
    nextTreeList: Map<string, Tree> = new Map();

    addIndex(index: number) {
        if (this.indexList.find(it => it === index)) {
            return;
        }

        this.indexList.push(index);
    }
}

class WordFilter {

    words: string[] = [];
    rootTree: Tree;
    rootReverseTree: Tree;

    constructor(words: string[]) {

        this.words = words;
        this.rootTree = new Tree();
        this.rootReverseTree = new Tree();

        words.forEach((word, index) => {
            this.addTree(this.rootTree, word, index);
            this.addTree(this.rootReverseTree, [...word].reverse().join(''), index);
        });

        // console.log('root', this.rootTree);
        // console.log('reverse', this.rootReverseTree);

    }

    addTree(rootTree: Tree, word: string, index: number) {
        let tree: Tree = rootTree;

        for (let i=0; i<word.length; i++) {
            const c = word[i];
            const t = tree.nextTreeList.get(c);
            if (t) {
                tree = t;
            } else {
                const tempTree = new Tree();
                tree.nextTreeList.set(c, tempTree);
                tree = tempTree;
            }
            tree.value = c;
            tree.addIndex(index);
        }
    }

    f(prefix: string, suffix: string): number {


        let tree: Tree = this.rootTree;
        let reverseTree: Tree = this.rootReverseTree;

        let indexList = [];
        let reverseIndexList = [];

        for (let i=0; i<prefix.length; i++) {
            const c = prefix[i];
            const t = tree.nextTreeList.get(c);
            if (t) {
                tree = t;
            }
        }

        const reverseSuffix = [...suffix].reverse().join('');

        for (let i=0; i<reverseSuffix.length; i++) {
            const c = reverseSuffix[i];
            const t = reverseTree.nextTreeList.get(c);
            if (t) {
                reverseTree = t;
            }
        }

        const items = []
        let resultIndex = -1;

        tree.indexList.forEach(it => items[it] = 1);
        reverseTree.indexList.forEach(it => {
            if (items[it]) {
                if (it > resultIndex) {
                    resultIndex = it;
                }
            }
        });



        return resultIndex;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * var obj = new WordFilter(words)
 * var param_1 = obj.f(prefix,suffix)
 */
