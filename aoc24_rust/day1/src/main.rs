
fn main() {
    let mut similarity_score  = 0;

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

    while !left.is_empty() {
        similarity_score += i32::abs(left.pop().unwrap() - right.pop().unwrap());
    }

    println!("Answer to day 1 part 1: {similarity_score}")
}
