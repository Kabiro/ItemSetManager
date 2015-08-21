var gulp = require('gulp'),
    connect = require('gulp-connect'),
    useref = require('gulp-useref'),
    gulpif = require('gulp-if'),
    uglify = require('gulp-uglify'),
    minifyCss = require('gulp-minify-css'),
    rimraf = require('gulp-rimraf'),
    jshint = require('gulp-jshint'),
    stylish = require('jshint-stylish'),
    ngAnnotate = require('gulp-ng-annotate');

var paths = {
    scripts: ['app/scripts/**/*.js'],
    html: ['app/index.html', 'app/views/**/*.html'],
    move: ['app/**', '!app/index.html', '!app/scripts/**', '!app/styles/**', '!app/bower_components/**'],
    css: ['app/styles/**/*.css'],
    dest: './../resources/public/',
    bootstrapFonts: ['app/bower_components/bootstrap/dist/fonts/**']
};

var all = []
    .concat(paths.scripts)
    .concat(paths.html)
    .concat(paths.css);

gulp.task('connect', function () {
    connect.server({
        root: 'app',
        livereload: true,
        port: 9000,
        middleware: function (connect, o) {
            return [(function () {
                var url = require('url');
                var proxy = require('proxy-middleware');
                var options = url.parse('http://localhost:8080/api');
                options.route = '/api';
                return proxy(options);
            })()];
        }
    });
});

gulp.task('lint', function () {
    return gulp.src(paths.scripts)
        .pipe(jshint())
        .pipe(jshint.reporter(stylish));
});

gulp.task('watch', function () {
    gulp.watch(all, ['lint'])
        .on('change', function (event) {
            gulp.src(event.path)
                .pipe(connect.reload());
        });
});

gulp.task('clean', function () {
    return gulp.src(paths.dest, {read: false})
        .pipe(rimraf({force: true}));
});

gulp.task('dist', ['clean'], function () {
    var assets = useref.assets();

    gulp.src(paths.move)
        .pipe(gulp.dest(paths.dest));

    gulp.src(paths.bootstrapFonts)
        .pipe(gulp.dest(paths.dest + '/fonts'));

    return gulp.src('app/index.html')
        .pipe(assets)
        .pipe(gulpif('*.js', ngAnnotate()))
        .pipe(gulpif('*.js', uglify()))
        .pipe(gulpif('*.css', minifyCss()))
        .pipe(assets.restore())
        .pipe(useref())
        .pipe(gulp.dest(paths.dest));
});

gulp.task('default', ['connect', 'lint', 'watch']);