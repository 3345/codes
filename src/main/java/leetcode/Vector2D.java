package leetcode;

import java.util.Iterator;
import java.util.List;

/**
 * Created by fyl on 3/26/18.
 */
public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> iterOuter;
    private Iterator<Integer> iterInner;

    public Vector2D(List<List<Integer>> vec2d) {
        this.iterOuter= vec2d.iterator();
    }

    @Override
    public Integer next() {
        if(iterInner != null && iterInner.hasNext()) {
            return iterInner.next();
        }

        if (iterOuter.hasNext()) {
            iterInner = iterOuter.next().iterator();
            return this.next();
        }

        return null;
    }

    @Override
    public boolean hasNext() {
        if (iterInner != null && iterInner.hasNext()) {
            return true;
        }

        if (iterOuter.hasNext()) {
            iterInner = iterOuter.next().iterator();
            return this.hasNext();
        } else {
            return false;
        }

    }
}