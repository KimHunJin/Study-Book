class MyCalendar {

    calendar = [];

    constructor() {
        this.calendar = [];
    }

    book(start: number, end: number): boolean {
        for (let d of this.calendar) {
            const [s, e] = d;
            if ( s < end && e > start) {
                return false;
            }
        }
        this.calendar.push([start, end]);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * var obj = new MyCalendar()
 * var param_1 = obj.book(start,end)
 */
