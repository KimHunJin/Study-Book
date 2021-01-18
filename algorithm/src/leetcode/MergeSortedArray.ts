/**
 Do not return anything, modify nums1 in-place instead.
 */
function merge(nums1: number[], m: number, nums2: number[], n: number): void {
    const nums1Size = nums1.length;
    nums1.splice(m, nums1Size);
    for (let i=0; i<n; i++) {
        nums1.push(nums2[i]);
    }
    nums1.sort((a,b) => a-b);
};
