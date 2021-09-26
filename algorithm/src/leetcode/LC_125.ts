function isPalindrome(s: string): boolean {
    const ps = s.replace(/[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/gi, '').replace(/\s/gi, '').toLowerCase();
    const lastIndex = ps.length - 1;
    for (let i=0; i<(ps.length / 2) + 1; i++) {
        const c = ps[i];
        const bc = ps[lastIndex - i];

        if (c !== bc) {
            return false;
        }
    }
    return true;
};
