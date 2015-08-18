echo "-----> cd into source"
cd ~/clj-blog
echo "-----> pull changes"
git pull
echo "-----> generate uberjar"
lein uberjar
echo "-----> restart nginx"
sudo nginx -s reload
