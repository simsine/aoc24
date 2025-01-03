use std::{collections::BinaryHeap, fs::read_to_string, cmp::Reverse};

fn main() {
    let mut similarity_score  = 0;

    let mut left = BinaryHeap::new();
    let mut right = BinaryHeap::new();

    for line in read_to_string("./input.txt").unwrap().lines() {
        let mut split = line.split("   ");
        
        let left_num = split.next().unwrap().parse::<i32>().unwrap();
        let right_num = split.next().unwrap().parse::<i32>().unwrap();

        left.push(Reverse(left_num));
        right.push(Reverse(right_num));

    }
    while !left.is_empty() {
        similarity_score += i32::abs(left.pop().unwrap().0 - right.pop().unwrap().0);
    }
    println!("Answer to day 1 part 1: {similarity_score}")
}
