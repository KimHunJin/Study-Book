function maximumTime(time: string): string {
    const times = time.split('');

    times[0] = times[0] === '?'
        ? Number(times[1]) >= 4
            ? '1' : '2'
        : times[0];

    times[1] = times[1] === '?'
        ? Number(times[0]) > 1
            ? '3' : '9'
        : times[1];

    times[3] = times[3] === '?' ? '5' : times[3];
    times[4] = times[4] === '?' ? '9' : times[4];

    return times.join('');
};
