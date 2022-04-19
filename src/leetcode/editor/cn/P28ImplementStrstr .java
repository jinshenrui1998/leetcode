package leetcode.editor.cn;
//Java：实现 strStr()
public class P28ImplementStrstr{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //next数组不右移版本，不好理解
    //kmp算法
    //kmp在循环中坚持的思想，双指针解决问题如何维护
    //进了循环
    //1.判断当前指针是否有效，如无效，则回退或者变到有效处
    //2.判断指针当前指针是否有效（因为可能没有有效处），如有效则进行有效操作
    //3.将指针至于下一个需要判断是否有效的位置，并进入下一循环
    public int strStr(String haystack, String needle) {
        //如果模式串为空，那么在文本串下标为0处就可以找到模式串
        if (needle.length() == 0) return 0;

        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }
    public void getNext(int[] next, String needle) {
        //思路：这里维护两个变量来构造next最长相等前后缀数组，一个是j前缀末尾，一个是i后缀末尾
        //next数组0位置初始为0不管，从1开始
        //每次进入循环，i和j都是新的后前缀末尾（待检验）
        //过程不多赘述，能看懂
        //说一下这里简化的地方，前一个字母的匹配前缀尾j，在后一个字母找前缀时起到的作用
        // 在上一次匹配之后 j之前的前缀（如果有，即不为0） 和i之前相等长度的后缀是匹配上的
        // 如果i和j处字母相同，那么就可以在原先的基础前缀的基础上加一，不用对前面进行检验
        // 例如 aabaab j = 2,i = 5, 意味着在4位置上的最长公共长度为2，而当前的j和i处的新的又相等，就直接再加一个就可以
        // 即使是在回退之后，只要不是回退到0，这个信息也可以利用
        // 例如 aabaaa j = 2, i = 5, 回退为 j = 1, i = 5
        // 意味着虽然4位置上的最长公共子串长度为2，但是长度为1的也是公共子串，长度为2的用不了，那就用长度为1的，只要和末尾值匹配就相等

        /*j的含义是前缀中待匹配的*/
        int j = 0; //前缀末尾 (的后一个，待检验的)
        for (int i = 1; i < needle.length(); i++) {
            //i为当前循环子串的后缀末尾(同j，为待检验的)
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == needle.charAt(i)) {
                j++;
            }
            //这里有一个小知识点，这里的j++起了两个作用
            //第一：相等的情况下，把j指针移到了下一个等待检验的位置
            //第二：本来j是下标，这里加一把j变成了长度信息
            next[i] = j;
        }
    }

    //next数组右移版本
    //对于j = next[j]更好理解
//    public int strStr(String haystack, String needle) {
//        if (needle.length() == 0) return 0;
//
//        int[] next = new int[needle.length() + 1];
//        getNext(next, needle);
//
//        int j = 0;
//        for (int i = 0; i < haystack.length(); i++) {
//            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
//                j = next[j];
//            }
//            if (needle.charAt(j) == haystack.charAt(i)) {
//                j++;
//            }
//            if (j == needle.length()) {
//                return i - j + 1;
//            }
//        }
//        return -1;
//    }
//
//    public void getNext(int[] next, String needle) {
//        //next数组记录了，当前位置之前不包括当前位置的最小公共子串
//        //下面这一句可以不写，因为默认初始为0
//        next[0] = -1;
//        //正常next[1] = 0 ,next[1]一定等于0，在这里用默认初始值0就行，如果写出next[1]=0反而会报错，因为有可能长度小于2
//        //next[0]没有意义
//        int j = 0;//g代表的是当前最大公共子串的长度，同时也是最大公共子串中前缀串的下一个下标
//        for (int i = 2; i < needle.length() + 1; i++) {
//            while (j > 0 && needle.charAt(j) != needle.charAt(i - 1)) {
//                j = next[j];
//            }
//            if (needle.charAt(j) == needle.charAt(i - 1)) {
//                j++;
//            }
//            next[i] = j;
//        }
//    }

//    // 2/15号最新理解
//    public int strStr(String haystack, String needle) {
//        if (needle.length() == 0) return 0;
//        int[] next = new int [needle.length()];
//        getNext(next, needle);
//        int j= 0;
//        for (int i = 0; i < haystack.length(); i++) {
//            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
//                // abcabcabcabc
//                // bcabd
//                // i = 5 j = 4 匹配不上了 j开始回退
//                // 也是模式串要前进了
//                // 要获取的信息就是， 模式串前进到哪儿合适
//                // 也就模式串的前几个字母和后几个字母一样可以安排到刚刚匹配的i的地方继续使用
//                j = next[j - 1];
//            }
//            if (haystack.charAt(i) == needle.charAt(j)) {
//                j++;
//            }
//            //这里j是下标，而needle.length是长度 所以是相等，下标等于长度就是移动到越界了
//            if (j == needle.length()) {
//                return i - needle.length() + 1;
//            }
//        }
//        return -1;
//    }
//    //这种不进行任何处理（右移和减一的）是适用范围最广，不用做额外变化的（数组长度+1）
//    //制作next数组的方法
//    public void getNext(int[] next, String needle) {
//        int left = 0;
//        for (int right = 0; right < needle.length(); right++) {
//            while (left > 0 && needle.charAt(right) != needle.charAt(left)) {
//                //这里的直接思路是:
//                //1.这里要做的是，如果匹配不上如何回退left
//                //首先明确，要匹配的是right处的字母
//                //已有信息 left指针指向的地方，是right - 1指针匹配的结果(最长公共前后缀)
//                //那么最长的结果就是left + 1处的字母和right处字母相等，就在原先的基础上加一
//                //第二场的结果如何得到
//                //right - 1的最长公共前后缀已知left，left处的最长公共前后缀也已知next[left]
//                //我们在这里要找的是，最后一段和right-1及其前面一部分匹配的串，并且把后面的
//                //并且把后面的一个字母拿出来和right处匹配，如果行就加一，存到right处
//                //right - 1前面的一小部分和left及其前面的全部相等 （假设有m个）
//                //而left及其前面的一小部分，又和next[left]前面的全部部分相等 （假设有n个，n < m)
//                //所以呢，通过传递，就把right - 1 前面n个，传到了字符串最前面的n个，形成
//                //公共前后缀，那么只要对他加以判断就行
//                left = next[left - 1];
//                //简单的而又哲学的说 来说就是从后缀部分回退到前缀部分
//            }
//            if (needle.charAt(right) == needle.charAt(left)) {
//                left += 1;
//            }
//            next[right] = left;
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

