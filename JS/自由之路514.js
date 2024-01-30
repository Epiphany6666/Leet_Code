/**
 * @param {string} ring
 * @param {string} key
 * @return {number}
 */

// 超时
var findRotateSteps = function (ring, key) {
    const indexMap = {}
    for (let i = 0; i < ring.length; i++) {
        const c = ring[i]
        if (indexMap[c]) {
            indexMap[c].push(i)
        } else {
            indexMap[c] = [i]
        }
    }

    const dfs = (ringI, keyI) => {
        if (keyI === key.length) {
            return 0;
        }
        const cur = key[keyI]
        let res = Infinity
        for (const targetI of indexMap[cur]) {
            const curMin = Math.min(Math.abs(ringI - targetI), ring.length - Math.abs(ringI - targetI))
            res = Math.min(res, curMin + dfs(targetI, keyI + 1))
        }
        return res
    }

    return key.length + dfs(0, 0)
};


// 自写记忆化
/**
 * @param {string} ring
 * @param {string} key
 * @return {number}
 */
var findRotateSteps = function(ring, key) {
    const indexMap = {}
    const map = {}
    for (let i = 0; i < ring.length; i++) {
        const c = ring[i]
        if (indexMap[c]) {
            indexMap[c].push(i)
        } else {
            indexMap[c] = [i]
        }
    }

    var dfs = (ringI, keyI) => {
        if (keyI === key.length) {
            return 0
        }
        const key1 = `${ringI}_${keyI}`
        if (map[key1]) return map[key1]
        // const cur = ring[ringI]
        const cur = key[keyI]
        let res = Infinity
        for (let targetI of indexMap[cur]) {
            const d1 = Math.abs(ringI - targetI)
            const d2 = ring.length - d1
            const curMin = Math.min(d1, d2)
            res = Math.min(res, curMin + dfs(targetI, keyI + 1))
        }
        map[key1] = res
        return res
    }

    return key.length + dfs(0, 0)
};

// 查询答案记忆化
var findRotateSteps = function (ring, key) {
    const indexMap = {}
    for (let i = 0; i < ring.length; i++) {
        const c = ring[i]
        if (indexMap[c]) {
            indexMap[c].push(i)
        } else {
            indexMap[c] = [i]
        }
    }

    const memo = new Array(ring.length)
    for (let i = 0; i < ring.length; i++) {
        memo[i] = new Array(key.length).fill(-1)
    }

    const dfs = (ringI, keyI) => {
        if (keyI === key.length) {
            return 0;
        }
        if (memo[ringI][keyI] != -1) return memo[ringI][keyI]
        const cur = key[keyI]
        let res = Infinity
        for (const targetI of indexMap[cur]) {
            const curMin = Math.min(Math.abs(ringI - targetI), ring.length - Math.abs(ringI - targetI))
            res = Math.min(res, curMin + dfs(targetI, keyI + 1))
        }
        memo[ringI][keyI] = res
        return res
    }

    return key.length + dfs(0, 0)
};