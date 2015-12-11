/*
 * Copyright (C) 2011 Pavel Fatin <http://pavelfatin.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.pavelfatin.game;

import java.awt.*;

//an enum is a defined set of variables, outside of which a variable cannot be set.  You can access these with Direction.values()
public enum Direction {
    None(0, 0),
    Left(-1, 0),
    Right(1, 0),
    Up(0, -1),
    Down(0, 1);


    public static final Direction[] MOVING_DIRECTIONS = {Left, Right, Up, Down};
    private Point _vector;

    // sets vector to be a certain point
    Direction(int x, int y) {
        _vector = new Point(x, y);
    }

    public Rectangle translate(Rectangle rectanle, int distance) {
        Rectangle result = new Rectangle(rectanle);
        result.translate(_vector.x * distance, _vector.y * distance);
        return result;
    }

    public boolean isPerpendicular(Direction direction) {
        if ((Left.equals(this) || Right.equals(this))
            && (Up.equals(direction) || Down.equals(direction))) {
            return true;
        }

        if ((Up.equals(this) || Down.equals(this))
            && (Left.equals(direction) || Right.equals(direction))) {
            return true;
        }

        return false;
    }
}
