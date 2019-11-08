use ceres_blog_db;

# posts table
insert into posts (title, body, post_details_id) values ('Sagittarius serpentarius', 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.', 1);
insert into posts (title, body, post_details_id) values ('Acridotheres tristis', 'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.', 2);
insert into posts (title, body, post_details_id) values ('Nannopterum harrisi', 'Fusce consequat. Nulla nisl. Nunc nisl.', 3);

# post details

insert into posts_details (is_awesome, history_of_post, topic_description) values
(true, 'history', 'love'),
(false, 'history', 'family'),
(true, 'history', 'teenager');

# images

insert into images (image_title, url, post_id) values
('dog', 'https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/12230414/Norwegian-Buhund-On-White-01.jpg', 1)