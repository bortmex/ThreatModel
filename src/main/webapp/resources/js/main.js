if (/*document.getElementById("checkpass2").value === document.getElementById("checkpass1").value*/true) {

    /*var game = new Phaser.Game(880, 560, Phaser.AUTO, null, {preload: preload, create: create, update: update});

    var ball;
    var paddle;

    function preload() {
        /!* handleRemoteImagesOnJSFiddle();*!/
        game.scale.scaleMode = Phaser.ScaleManager.SHOW_ALL;
        game.scale.pageAlignHorizontally = true;
        game.scale.pageAlignVertically = true;
        game.stage.backgroundColor = '#eee';
        game.load.image('ball', 'resources/image/ball3.png');
        game.load.image('paddle', 'resources/image/paddle.png');
    }

    function create() {
        game.physics.startSystem(Phaser.Physics.ARCADE);
        ball = game.add.sprite(game.world.width * 0.5, game.world.height - 25, 'ball');
        ball.anchor.set(0.5);
        game.physics.enable(ball, Phaser.Physics.ARCADE);
        ball.body.velocity.set(150, -150);
        ball.body.collideWorldBounds = true;
        ball.body.bounce.set(1);

        paddle = game.add.sprite(game.world.width * 0.5, game.world.height - 5, 'paddle');
        /!*paddle.anchor.set(0.5, 1);*!/

        paddle.width = 80;
        paddle.height = 80;

        game.physics.enable(paddle, Phaser.Physics.ARCADE);
        paddle.body.immovable = true;

    }

    function update() {
        game.physics.arcade.collide(ball, paddle);
        paddle.x = game.input.x || game.world.width * 0.5;
    }

    var game = (function () {

        var f = 0,
            lt = new Date(),
            rate = 1000 / 12,
            w = false, // walk animation bool

            // walk animation
            walk = function (sprite) {

                sprite.frame = f + 2;

                if (new Date() - lt > rate) {

                    f += 1;
                    if (f == 2) {

                        f = 0;

                    }

                    lt = new Date();

                }

            };

        return new Phaser.Game(320, 240, Phaser.AUTO, 'gamearea', {

            // load the sprite sheet
            preload : function () {

                game.load.spritesheet('cucco', 'resources/image/ball3.png', 120, 10, 10);

            },

            // create the sprite
            create : function () {

                var sprite = game.add.sprite(160 - 40, 120 - 40, 'cucco');

                sprite.width = 80;
                sprite.height = 80;

                var k = game.input.keyboard;

                // A
                k.addKey(65).onHoldCallback = function (key) {

                    sprite.x -= 1;
                    w = true;

                };

                // D
                k.addKey(68).onHoldCallback = function (key) {

                    sprite.x += 1;
                    w = true;

                };

                k.addKey(87).onHoldCallback = function (key) {

                    sprite.y -= 1;
                    w = true;

                };

                k.addKey(83).onHoldCallback = function (key) {

                    sprite.y += 1;
                    w = true;

                };

                // set walk bool back to false on any keyup event
                k.onUpCallback = function () {

                    w = false;

                }

            },

            update : (function () {

                return function () {

                    var sprite = game.world.children[0];

                    // default sprite to frame 0
                    sprite.frame = 0;

                    if (w) {

                        walk(sprite);

                    }

                };

            }
            ())

        }, false, false);

    }
    ());

    <script>
    if(){
        var canvas = document.getElementById("myCanvas");
        var ctx = canvas.getContext("2d");
        var ballRadius = 10;
        var colN = Number.parseInt(prompt("Введите количество шаров", 10));
        var x = new Array(colN);
        for (var i = 0; i < x.length; i++) {
            x[i] = canvas.width / 2;
        }
        var y = new Array(colN);
        for (var i = 0; i < y.length; i++) {
            y[i] = canvas.height - 30;
        }
        var color = new Array(762);
        for (var i = 0; i < 254; i++) {
            for (var j = 0; j < 254; j++) {
                for (var k = 0; k < 254; k++) {
                    color[i + j + k] = 'rgb(' + i + ',' +
                        j + ',' + k + ')';
                }
            }
        }

        var dx = new Array(colN);
        var dy = new Array(colN);

        for (var i = 0; i < colN; i++) {
            dx[i] = getRandomInt(-10, 10);
        }

        for (var i = 0; i < colN; i++) {
            dy[i] = getRandomInt(-10, 10);
        }

        var paddleHeight = 10;
        var paddleWidth = 75;
        var paddleX = (canvas.width - paddleWidth) / 2;
        var paddleY = canvas.height - paddleHeight;
        var rightPressed = false;
        var leftPressed = false;
        var upPressed = false;
        var downPressed = false;

        document.addEventListener("keyup", keyDUHandler, false);
        document.addEventListener("keydown", keyLRHandler, false);


        function drawBall() {
            for (var i = 0; i < colN; i++) {
                ctx.beginPath();
                ctx.arc(x[i], y[i], ballRadius, 0, Math.PI * 2);
                color = shuffle(color);
                ctx.fillStyle = color[getRandomInt(0, 761)];
                ctx.fill();
                ctx.closePath();
            }
        }

        function keyLRHandler(e) {
            if (e.keyCode === 68) {
                rightPressed = true;
            }
            else if (e.keyCode === 65) {
                leftPressed = true;
            } else if (e.keyCode === 83) {
                upPressed = true;
            }
            else if (e.keyCode === 87) {
                downPressed = true;
            }
        }

        function keyDUHandler(e) {
            if (e.keyCode === 68) {
                rightPressed = false;
            }
            else if (e.keyCode === 65) {
                leftPressed = false;
            } else if (e.keyCode === 83) {
                upPressed = false;
            }
            else if (e.keyCode === 87) {
                downPressed = false;
            }
        }

        function drawPaddle() {
            ctx.beginPath();
            ctx.rect(paddleX, paddleY, paddleWidth, paddleHeight);
            ctx.fillStyle = "#0095DD";
            ctx.fill();
            ctx.closePath();
        }

        function draw() {
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            drawBall();
            drawPaddle();
            for (var i = 0; i < dx.length; i++) {
                if (x[i] + dx[i] > canvas.width - ballRadius || x[i] + dx[i] < ballRadius) {
                    dx[i] = -dx[i];
                }
            }
            for (var i = 0; i < dy.length; i++) {
                if (y[i] + dy[i] > canvas.height - ballRadius || y[i] + dy[i] < ballRadius) {
                    dy[i] = -dy[i];
                }
            }
            if (rightPressed && paddleX < canvas.width - paddleWidth) {
                paddleX += 7;
            }
            else if (leftPressed && paddleX > 0) {
                paddleX -= 7;
            } else if (upPressed && paddleY < canvas.height - paddleHeight) {
                paddleY += 7;
            }
            else if (downPressed && paddleY > 0) {
                paddleY -= 7;
            }

            for (var i = 0; i < y.length; i++) {
                if ((x[i] + ballRadius > paddleX && x[i] - ballRadius < paddleX + paddleWidth)
                    && (y[i] + ballRadius > paddleY && y[i] - ballRadius < paddleY + paddleHeight)) {
                    dy[i] = -dy[i];
                }
            }

            for (var i = 0; i < dx.length; i++) {
                x[i] += dx[i];
                y[i] += dy[i];
            }
        }

        function getRandomInt(min, max) {
            return Math.floor(Math.random() * (max - min + 1)) + min;
        }

        function shuffle(array) {
            var currentIndex = array.length, temporaryValue, randomIndex;

            // While there remain elements to shuffle...
            while (0 !== currentIndex) {

                // Pick a remaining element...
                randomIndex = Math.floor(Math.random() * currentIndex);
                currentIndex -= 1;

                // And swap it with the current element.
                temporaryValue = array[currentIndex];
                array[currentIndex] = array[randomIndex];
                array[randomIndex] = temporaryValue;
            }

            return array;
        }

        setInterval(draw, 10);
    }

</script>*/

}