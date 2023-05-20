function canChange(start: string, target: string): boolean {
    let startCount = 0
    let targetCount = 0

    let startOrder = ''
    let targetOrder = ''
    const map = [...start].map(it => {
        if (it === 'L') {
            startCount++
            startOrder += 1
            return 1
        } else if (it === 'R') {
            startCount++
            startOrder += 2
            return 2
        } else {
            return 0
        }
    })
    
    
    const targetMap = [...target].map(it => {
        if (it === 'L') {
            targetCount++
            targetOrder += 1
            return 1
        } else if (it === 'R') {
            targetCount++
            targetOrder += 2
            return 2
        } else {
            return 0
        }
    })
    
    if (startCount !== targetCount) {
        return false
    }
    
    if (startOrder !== targetOrder) {
        return false
    }

    const possible: number[] = Array.from({length: start.length}).fill(0) as number[]
    
    for (let i=0; i<start.length; i++) {
        if (start[i] === 'L') {
            possible[i] = 1
            for (let j=i-1; j>=0; j--) {
                if (map[j] === 0) {
                    possible[j] = possible[j] + 1
                }
                if (map[j] === 1 || map[j] === 2) {
                    break
                }
            }
        }
        if (start[i] === 'R') {
            possible[i] = 2
            for (let j=i+1; j<start.length; j++) {
                if (map[j] === 0) {
                    possible[j] = possible[j] + 2
                }
                if (map[j] === 1 || map[j] === 2) {
                    break
                }
            }
        }
    }
    
   
    let answer = true
        
    for (let i=0; i<targetMap.length; i++) {
        const p = possible[i]
        const t = targetMap[i]
        
        if (i === 0) {
            if (start[i] === 'L') {
                if (target[i] !== 'L') {
                    return false
                }
            }
        }
        if (i === start.length - 1) {
            if(start[i] === 'R') {
                if (target[i] !== 'R') {
                    return false
                }
            }
        }
    
        if (p === 0) {
            if (t === 0) {
                answer = true
            } else if (t === 1) {
                answer = false
            } else if (t === 2) {
                answer = false
            } else if (t === 3) {
                answer = false
            }
            
            if (!answer) {
                break
            }
        }
        
        if (p === 1) {
            if (t === 1) {
                answer = true
            } else if (t === 0) {
                answer = true
            } else if (t === 2) {
                answer = false
            } else if (t === 3) {
                answer = true
            }
            
            if (!answer) {
                break
            }
        }
        
        if (p === 2) {
            if (t === 1) {
                answer = false
            } else if (t === 0) {
                answer = true
            } else if (t === 2) {
                answer = true
            } else if (t === 3) {
                answer = true
            }
            
            if (!answer) {
                break
            }
        }
    }
    return answer
};
