
fn main() {
    let (left, right) = get_input();

    println!("Answer to day 1 part 1: {}", part_1(&left, &right));
    println!("Answer to day 1 part 1: {}", part_2(&left, &right));
}   

fn get_input() -> (Vec<i32>, Vec<i32>) {
    let mut left = Vec::new();
    let mut right = Vec::new();

    for line in include_str!("input.txt").lines() {
        let mut split = line.split("   ");
        
        let left_num = split.next().unwrap().parse::<i32>().unwrap();
        let right_num = split.next().unwrap().parse::<i32>().unwrap();

        left.push(left_num);
        right.push(right_num);
    }

    left.sort_unstable();
    right.sort_unstable();

    (left, right)
}

fn part_1(left:&Vec<i32>, right:&Vec<i32>) -> i32 {
    left.iter().zip(right.iter())
        .map(|(l, r)| (l-r).abs())
        .sum()
}

fn part_2(left:&Vec<i32>,  right:&Vec<i32>) -> i32 {
    let mut similatity_score = 0;
    for left_num in left {
        let in_right = right.iter().filter(|t| **t == *left_num).count() as i32;
        similatity_score += left_num * in_right;
    }
    return similatity_score;
}
