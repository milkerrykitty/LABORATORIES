package lapa8;

public class lapa8_2 {

    int n;
    int[] tree;

    public lapa8_2(int[] a)
    {
        n = a.length;
        tree = new int[4 * n];
        build(a, 1, 0, n);
    }

    void build(int[] a, int v, int l, int r) {
        if (r - l == 1) {
            tree[v] = a[l];
            return;
        }

        int mid = (l + r) / 2;

        build(a, v * 2, l, mid);
        build(a, v * 2 + 1, mid, r);

        tree[v] = Math.min(tree[v * 2], tree[v * 2 + 1]);
    }

    int zapros(int v, int l, int r, int zaprosl, int zaprosr) {
        if (r <= zaprosl || l >= zaprosr)
            return Integer.MAX_VALUE;

        if (zaprosl <= l && r <= zaprosr)
            return tree[v];

        int mid = (l + r) / 2;

        return Math.min(
                zapros(v * 2, l, mid, zaprosl, zaprosr),
                zapros(v * 2 + 1, mid, r, zaprosl, zaprosr)
        );
    }

    public int zapros(int l, int r) {
        return zapros(1, 0, n, l, r);
    }


}
