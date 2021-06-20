function countPrimes(n: number): number {

    const prime = Array.from({length: n}, () => true);

    prime[0] = false;
    prime[1] = false;

    for (let i=2; i<=n; i++) {
        if (!prime[i]) {
            continue;
        }

        for (let j=2*i; j<=n; j+=i) {
            prime[j] = false;
        }
    }


    let result = 0;

    for (let i=0; i<=n; i++) {
        if (prime[i]) {
            result ++;
        }
    }

    return result;
};
